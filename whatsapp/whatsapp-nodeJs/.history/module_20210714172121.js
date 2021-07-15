class   ModuleFunction{


     parseUrl(req,res){
        url = require('url');
        url_parts = url.parse(req.url, true);
        query = url_parts.query;

        console.log(url);
       

    }


}



module.exports = ModuleFunction