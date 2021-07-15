let http = require("http");
const module = require("Module");

http.createServer(function(req,res){
    console.log(req.url);
    module
    console.log("controller");
}).listen(3000)


