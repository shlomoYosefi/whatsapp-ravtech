let http = require("http");
const Module = require("module");
let module = Module

http.createServer(function(req,res){
    console.log(req.url);
    
    console.log("controller");
}).listen(3000)


