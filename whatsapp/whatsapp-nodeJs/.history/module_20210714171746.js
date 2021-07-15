class   ModuleFunction{

     url = require('url');
     url_parts = url.parse(request.url, true);
     var query = url_parts.query;

     parseUrl(req,res){
        let url = req.url
        let param = req.url
        console.log(url);
    }


}



module.exports = ModuleFunction