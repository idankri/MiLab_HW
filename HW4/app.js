// imports
const express = require('express');
const jsonfile = require('jsonfile');
const bodyParser = require('body-parser');

// global variables
const json_data = 'tasks_data.json'

let app = express();
app.use(bodyParser.json());

// /tasks should display all tasks
app.get('/tasks', (req, res) => {
    jsonfile.readFile(json_data)
    .then(data => res.send(data))
    .catch(error => console.error(error));
});

// /tasks/new should add a new task to the json file
app.get('/tasks/new', (req, res) => {
    // parse id field and validate it
    let id = req.query.id || null;
    if(id == null || isNaN(id)){
        res.send("Invalid input for argument \'id\'");
        return;
    }
    // parse task field and validate it
    let task = req.query.task || null;
    if(task == null){
        res.send("Invalid input for argument \'task\'");
        return;
    }
    // create appropriate object and add to JSON file
    let json_obj = {"id": id, "task": task};

    jsonfile.readFile(json_data).
    then((data) => {
        // check if the input id exists and if it does update it
        let did_not_update = data.every((element) => {
            if(element.id == id){
                element.task = task;
                return false;
            }
            return true;
        });
        // if all returns were true, did_not_update should be true
        if(did_not_update) data.push(json_obj);
        jsonfile.writeFile(json_data, data, (err) => {if(err) console.error(err)});
    }).catch(error => console.error(error));
    res.send();
});

app.get('/tasks/remove', (req, res) => {
    // parse id field and validate it
    let id = req.query.id || null;
    if(id == null || isNaN(id)){
        
        res.send("Invalid input for argument \'id\'");
        return;
    }

    // read the JSON file, filter unwanted elements and write back
    jsonfile.readFile(json_data).
    then(data => {
        data = data.filter((element) => {
            return element.id != id;
        });
        jsonfile.writeFile(json_data, data, (err) => {if(err) console.error(err)});
    }).catch(error => console.error(error));
    res.send();
});


app.listen(3000, () =>{
    console.log('Listening on port 3000');
});