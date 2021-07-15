let http = require("http")
let module = 

http.createServer(function(req,res){
    console.log(req.url);
    
    console.log("controller");
}).listen(3000)


