/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/* 
 * Desde BC
 *
 */

        var timeline;
        var data;
        
        
function getSelectedRow() {
  var row = undefined;
  var sel = timeline.getSelection();
  if (sel.length) {
      if (sel[0].row != undefined) {
          row = sel[0].row;
      }
  }
  return row;
}

     
        function drawVisualization(jsonName) {
$(document).ready(function() {
$.ajaxSetup({ cache: false });
});

/*el formato es el siguiente YYYY,mm,DD,hh,mm,ss  */
var start = getUrlVars()["start"];
var fin = getUrlVars()["fin"];
if(start && fin){
var startDateObject=eval("new Date("+start+")");
var finDateObject=eval("new Date("+fin+")");
console.log("_____________________val");
}else{
 console.log("____________________no val");   
}

$.ajax(
{
    url: server,
    data: {opc:'2'},
    success: function(response)
    {
                       var dataj=null;
                       console.log(response);
                       eval("dataj="+ response + ";"); // Codifica a Json 


var dataSize=dataj.length;
for(var i=0;i<dataSize;i++){
dataj[i].start=eval(dataj[i].start);
dataj[i].end=eval(dataj[i].end);
console.log("start:" +dataj[i].start +"  end:" + dataj[i].end + "   index:" + i);
}
   data=dataj;

console.log(data);


        if(start && fin)
                var options = {
                    'width':  '100%',
                    'height': '600px',
                    'start' : startDateObject,
                    'end'   : finDateObject,
                    'editable': true,   // enable dragging and editing events
                    'style': 'box',
                    'locale' : 'es'
                };
        else
                var options = {
                'width':  '100%',
                'height': '600px',
                'editable': true,   // enable dragging and editing events
                'style': 'box',
                'locale' : 'es'
               };


       //instanciamos
        timeline = new links.Timeline(document.getElementById('mytimeline'));

        function onRangeChanged(properties) {
            document.getElementById('info').innerHTML += 'rangechanged ' +
                    properties.start + ' - ' + properties.end + '<br>';
        }


        links.events.addListener(timeline, 'select', onselect);

        // Draw our timeline with the created data and options
        timeline.draw(data, options);


    }
});

/*
   $.getJSON("json/fileprueba.json?"+new Date().getTime(), function(dataj) {
    var dataSize=dataj.length;
    for(var i=0;i<dataSize;i++){
    dataj[i].start=eval(dataj[i].start);
    dataj[i].end=eval(dataj[i].end);
    console.log("start:" +dataj[i].start +"  end:" + dataj[i].end + "   index:" + i);
   }
       data=dataj;
   
   console.log(data);
            // specify options
            var options = {
                'width':  '100%',
                'height': '600px',
                'editable': true,   // enable dragging and editing events
                'style': 'box',
                'locale' : 'es'
            };
            

            // Instantiate our timeline object.
            timeline = new links.Timeline(document.getElementById('mytimeline'));

            function onRangeChanged(properties) {
                document.getElementById('info').innerHTML += 'rangechanged ' +
                        properties.start + ' - ' + properties.end + '<br>';
            }

            // attach an event listener using the links events handler
            links.events.addListener(timeline, 'rangechanged', onRangeChanged);
            links.events.addListener(timeline, 'select', onselect);

            // Draw our timeline with the created data and options
            timeline.draw(data, options);
   
   });*/
    
            
        }
        

/*
* Added  
 */
function getUrlVars() {
    var vars = {};
    var parts = unescape(window.location.href).replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
        
        
         // Callback  render de eventos
var onselect = function (event) {
    var row = getSelectedRow();
    if (row != undefined) {
        document.getElementById("info").innerHTML += "item " + row + " selected ::  datos: "+ data[row].content +" start: "+data[row].start+"<br>";
        // Note: you can retrieve the contents of the selected row with
        //       data.getValue(row, 2);
    }
    else {
        document.getElementById("info").innerHTML += "no item selected<br>";
    }

    alert(" " + row);
};
