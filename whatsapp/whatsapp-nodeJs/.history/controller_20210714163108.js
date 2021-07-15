let http = require("http")


http.createServer(function(req,res){
    console.log(req.url);
    
    console.log();
    res.end()
}).listen(3000)


