let http = require("http")


http.createServer(function(req,res){
    console.log(req.p);
    res.write("hello world!")
    res.end()
}).listen(3000)


console.log("lllllllllllllll");