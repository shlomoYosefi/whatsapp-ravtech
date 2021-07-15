let http = require("http")
let module = M

http.createServer(function(req,res){
    console.log(req.url);
    
    console.log("controller");
}).listen(3000)


