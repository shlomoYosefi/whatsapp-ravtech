let http = require("http");
const Module = require("./module");
let module = new Module

http.createServer(function(req,res){
    console.log(req.url);
    module.
    console.log("controller");
}).listen(3000)


