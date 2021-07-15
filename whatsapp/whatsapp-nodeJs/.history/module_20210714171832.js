class   ModuleFunction{

     url = require('url');

     parseUrl(req,res){
        url_parts = url.parse(req.url, true);
        console.log(url);

    }


}



module.exports = ModuleFunction