let http = require("http");
const ModuleFunction = require("./module");
let module = new Module()




http.createServer(function(req,res){
    console.log(req.url);
    module.parseUrl(req,res)
    console.log("controller");
}).listen(3000)


