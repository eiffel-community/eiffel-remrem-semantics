/* download.js script is used to update the jitpack releases of semantics
 *  in gh-pages dynamically and to support the downloading functionality 
 *  of templates based on the release version of semantics.
 *  */

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var myArr = JSON.parse(xmlhttp.responseText);
            populateRelease(myArr);
            buildHtmlTable('#eventTypesTable');
        }
    }
    xmlhttp.open("get","https://api.github.com/repos/eiffel-community/eiffel-remrem-semantics/releases",true);
    xmlhttp.send();

    //To populate the semantics jipack released versions with templates.
    function populateRelease(arr) {
        for (var i = 0; i < arr.length; i++) {
            var releaseVersion = arr[i].tag_name;
            var value = parseFloat(releaseVersion.replace('.', ''));
            if (value >= 2.5) {
                dropDownList(arr[i].tag_name);
            }
        }
    }

    //To update the drop-down list with latest releases.
    function dropDownList(release) {
        var s = document.getElementById('version');
        s.options[s.options.length] = new Option(release, release);
    }

    // To download the template of specific event.
    function downloadTemplate(eventName) {
        var version = document.getElementById('version').value;
        var URL = "https://raw.githubusercontent.com/eiffel-community/eiffel-remrem-semantics/"
                + version
                + "/src/main/resources/templates/"
                + eventName
                + ".json";
        downloadURL(URL, eventName);
    }

    // To download the templates from semantics repository.
    function downloadURL(repoUrl, templateName) {
        var link = document.createElement("a");
        link.download = templateName;
        link.href = repoUrl;
        link.click();
    }
