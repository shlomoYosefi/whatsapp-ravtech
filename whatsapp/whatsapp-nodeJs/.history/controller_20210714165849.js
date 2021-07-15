let http = require("http");
const ModuleFunction = require("./module");
let moduleFunction = new ModuleFunction()




http.createServer(function(req,res){
    moduleFunction.parseUrl(req,res)
}).listen(3000)


