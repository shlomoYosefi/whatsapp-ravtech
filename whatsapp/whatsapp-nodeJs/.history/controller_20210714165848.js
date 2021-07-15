let http = require("http");
const ModuleFunction = require("./module");
let moduleFunction = new ModuleFunction()




http.createServer(function(req,res){
    moduleFunction.parseUrl(req,res)
    console.log("controller");
}).listen(3000)


