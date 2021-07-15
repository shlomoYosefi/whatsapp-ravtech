class   ModuleFunction{

     url = require('url');
     url_parts = url.parse(request.url, true);
     query = url_parts.query;

     parseUrl(req,res){
        console.log(url);
    }


}



module.exports = ModuleFunction