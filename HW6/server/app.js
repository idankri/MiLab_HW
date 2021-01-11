const express = require('express');
const FCM = require('fcm-push');

const API_KEY =  'NV713Q1NZHCSFDU9'; //enter alpha vantage API KEY here
const ALPHA_VANTAGE_URL = 'https://www.alphavantage.co/query';

let SYMBOL;
let params = {function: "GLOBAL_QUOTE", symbol: SYMBOL, apikey: API_KEY};
let app = express();

function fetchStockData(){
    //parse URL
    let url = new URL(ALPHA_VANTAGE_URL);
    Object.keys(params).forEach(key => url.searchParams.append(key, params[key]));
    // fetch data
    let rec_data;
    fetch(url , {method: 'GET'})
    .then(response => response.json())
    .then(data => rec_data = data)
    .catch((error) => {
        console.error('ERROR: ', error);
        throw 'Failed to retreive data from REST';
    });
    // return last known price
    return rec_data["Global Quote"]["05. price"];

}

app.get('/:symbol', (req, res) => {
    // I set the interval to 1 day as AlphaVantage API doesn't support mid-day prices
    // for free users
    SYMBOL = req.params.symbol;
    params.symbol = SYMBOL;
    setInterval(()=>{

    }, 1000);
});

app.post('/token/:token', (req, res) => {
    // insert token into mongoDB
})