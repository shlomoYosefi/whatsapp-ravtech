let http = require("http")


http.createServer(function(req,res){
    console.log(req.url);
    console.log("lllllllllllllll");
    res.write("hello world!")
    res.end()
}).listen(3000)


