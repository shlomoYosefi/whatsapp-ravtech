class   ModuleFunction{

     url = require('url');

     parseUrl(req,res){
        thisurl_parts = url.parse(req.url, true);
        query = url_parts.query;

        console.log(url);
        console.log(url_parts);
        console.log(query);

    }


}



module.exports = ModuleFunction