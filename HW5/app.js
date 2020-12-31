
// imports
const express = require('express');
const fs = require('fs');

// init app
let app = express();

/**
 *  The app will listen to all incoming requests, and will return the corresponding file or a message the file doesn't exists.
 *  It will be done by piping the file to the result as instructed
 * */ 
app.get('*', (req, res) => {
    // parse filename
    let path = __dirname + req.url;
    // check if the file exists and act accordingly
    if(!fs.existsSync(path) || fs.lstatSync(path).isDirectory()){
        res.send("404 Not found :(");
        return;
    }
    // if the file exists pipe it to the response
    const readStream = fs.createReadStream(path);
    readStream.pipe(res);
});


app.listen(3000, () => {
    console.log("Listening on port 3000");
});