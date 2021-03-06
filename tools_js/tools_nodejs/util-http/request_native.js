var http = require('http'),
    qs = require('querystring');

var genReq = function(options) {
    console.log("URL: " + options.host + ":" + options.port + options.path);
    var req = http.request(options, function(res) {
        console.log('success|response|status|' + res.statusCode);
        console.log('success|response|headers|' + JSON.stringify(res.headers));

        res.setEncoding('utf8');

        var responseString = '';

        res.on('data', function(chunk) {
            responseString += chunk;
        });

        res.on('end', function() {
            // var resultObject = JSON.parse(responseString);
            console.log('success|response|body|', responseString);
        });
    });

    req.on('error', function(e) {
        console.log('error|request_native|' + e.message);
    });

    return req;
}

function get(options, data) {
    options.method = "GET";
    var content = qs.stringify(data);
    options.path = options.path + "?" + content;
    var req = genReq(options);
    req.end();
}

function post(options, body) {
    options.method = "POST";
    var bodyString;
    if (options.headers["Content-Type"].indexOf("json") > 0)
        bodyString = JSON.stringify(body);
    else
        bodyString = qs.stringify(body);
    
    var req = genReq(options);

    // write data to request body
    req.write(bodyString);
    req.end();
}

module.exports = {
    get: get,
    post: post
}