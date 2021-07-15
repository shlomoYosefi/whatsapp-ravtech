class   ModuleFunction{

     url = require('url');
     query = url_parts.query;

     parseUrl(req,res){
        url_parts = url.parse(request.url, true);

        console.log(url);

    }


}



module.exports = ModuleFunction