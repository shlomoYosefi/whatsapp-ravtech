class   ModuleFunction{

     url = require('url');

     parseUrl(req,res){
        url_parts = url.parse(req.url, true);
        query = url_parts.query;

        console.log(url);
        console.log(url);
        console.log(url);

    }


}



module.exports = ModuleFunction