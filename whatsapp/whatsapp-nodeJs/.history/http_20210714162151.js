let http = require("http")


http.createServer(function(req,res){
    console.log(req);
    res.write("hello world!")
    res.c
}).listen(3000)