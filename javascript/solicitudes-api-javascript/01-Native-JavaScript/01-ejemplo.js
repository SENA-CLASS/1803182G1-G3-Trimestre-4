function ajaxJS(url) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            output(xhr.responseText, xhr.status, 'JavaScript response');
        }
    };
    xhr.open('GET', url, true);
    xhr.send();
}

function output(responseText, status, xhr) {
    var output = document.getElementById('output');
    responseText = ((typeof responseText) === 'string') ? JSON.parse(responseText) : responseText;
    console.log(responseText);
    output.innerHTML = '<div><span class="heading">Response Text</span><p>' + JSON.stringify(responseText) + '</p></div>';
    output.innerHTML += '<div><span class="heading">Status</span><p>' + JSON.stringify(status) + '</p></div>';
    output.innerHTML += '<div><span class="heading">Response</span><p>' + JSON.stringify(xhr) + '</p></div>';
}

ajaxJS("https://reqres.in/api/users?page=2");
