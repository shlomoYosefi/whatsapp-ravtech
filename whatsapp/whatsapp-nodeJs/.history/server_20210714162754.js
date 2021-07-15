let http = require("http")


http.createServer(function(req,res){
    console.log(req.url);
    res.write("hello world!")
    res.end()
}).listen(3000)


