let http = require("http")


http.createServer(function(req,res){
    console.log(req.url);
    
    console.log();
}).listen(3000)


