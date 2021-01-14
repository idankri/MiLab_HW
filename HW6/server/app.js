"use strict";

// imports
const express = require('express');
const FCM = require('fcm-push');
const bodyParser = require('body-parser');
const fetch = require("node-fetch");

//globals
const PORT = 8080;
const API_KEY =  'NV713Q1NZHCSFDU9'; //enter alpha vantage API KEY here
const ALPHA_VANTAGE_URL = 'https://www.alphavantage.co/query';
const collection = "tokens";
const FCM_SERVER_KEY = "AAAArjuCf8U:APA91bH5PpDYttNRP6x2hY2xx0r2jlhlyIaPVREY-jpQuxFKEIGJvMm4WuNovjbBzJEOwbdli-nv6mNUDxFhTyjHVd-jrHFwaF5OrWQyOgmWZ1bvFF_Wet628SIejhy7zY7w4sxI5-Ts";
let token = "";
let symbol = "";

// init app
let app = express();
app.use(bodyParser.json());

// init fcm
let fcm = new FCM(FCM_SERVER_KEY);

// function that receives a symbol and a callback, 
// fetches the stock data related to that symbol and calls the callbak on finish
const fetchStockData = (symbol, cb) => {
    //parse URL
    let url = new URL(ALPHA_VANTAGE_URL);
    let params = {function: "GLOBAL_QUOTE", symbol: symbol, apikey: API_KEY};
    Object.keys(params).forEach(key => url.searchParams.append(key, params[key]));
    // fetch data and execute callback
    fetch(url , {method: 'GET'})
    .then(response => response.json())
    .then((data) => {
        cb(data["Global Quote"]["05. price"]);
    })
    .catch((error) => {
        console.error('ERROR: ', error);
        cb("", error);
    });
}

// sends a notification through firebase
const send_notification = (token, symbol, price) => {
    fcm.send({
        to: token,
        data: {},
        notification: {
            title: "Your " + symbol + " update!",
            body: "Current price: " + price
        }
    }, (error, response) => {
        if(error){
            console.log(error);
        }
    });
    
}

// update token
app.post('/token/:token', (req, res) => {
    token = req.params.token;
    console.log("Got new token: " + token);
    res.json({result: "success"});
});

// subscribe a user to a symbol
app.post('/symbol/:symbol', (req, res) => {
    token = req.body.token;
    symbol = req.params.symbol;
    console.log("Got new symbol: " + symbol + " token: " + token);
    // set a recurring method that fetches the stock data and sends a notification
    // to the user
    setInterval(()=>{
        fetchStockData(symbol, (price, err) => {
            if(err){
                console.log(err);
            }
            else{
                send_notification(token, symbol, price);
            }
        })
    }, 30000);
    res.json({result: "success"});
});

// start app
app.listen(PORT, () => {
    console.log('App listening on port ' + PORT);
});