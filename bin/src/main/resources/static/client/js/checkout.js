var state = 0;
var stateMax = 5;

console.log("Next", state);


function next() {
	console.log("Next", state);
	// browser side functions here
}

function back() {
	console.log("Back", state);
	// browser side functions here
}

$("#next").click(function () {
	state += 1;
	if (state <= stateMax) {


		next();


		// mở khoá nút back
		$("#back").removeClass("disabled");

		// add màu xanh cho thanh bar
		$(".nConfirm" + state).each(function () {
			$(this).addClass("done");
		});

		// Progress bar animation
		var pBar = (state / stateMax) * 125;
		$(".pBar").css("width", `${pBar}%`);


		if (state == 0) {
		

		} if (state == 1) {
			$(".information").removeClass("hidden");
			$(".address").addClass("hidden");

		} if (state == 2) {
			$(".address").removeClass("hidden");
			$(".review").addClass("hidden");

		}
		// đổi nút next thành finish
		if (state == 3) {
			$(".review").removeClass("hidden");
			$(".payment").addClass("hidden");



		}
		if (state == 4) {
			$(".payment").removeClass("hidden");
			$(".complete").addClass("hidden");
			$("#next").html('<b>Finish</b>');
		}
		//// sự kiện gửi form lên servẻ
		if (state == 5) {
			$("#back").addClass("disabled");
			$("#next").addClass("disabled");
			$("#back").attr('disabled','disabled');
			$('#next').attr('disabled','disabled');
			$(".complete").removeClass("hidden");
			$(".finish").addClass("hidden");
			alert("gửi form lên server")

		}

	}
});

$("#back").click(function () {
	back();
	if (state >= 0) {
		
		$("#next").removeClass("disabled");
		$(".nConfirm" + state).each(function () {
			$(this).removeClass("done");
		});
		state -= 1;
		var pBar = (state / stateMax) * 125;
		$(".pBar").css("width", `${pBar}%`);

		if (state == 0) {
			$("#back").addClass("disabled");
			$(".information").addClass("hidden");
			$(".address").removeClass("hidden");
		}

		if (state == 1) {
			$(".address").addClass("hidden");
			$(".review").removeClass("hidden");

		} if (state == 2) {
			$(".review").addClass("hidden");
			$(".payment").removeClass("hidden");

		} if (state == 3) {
			$(".payment").addClass("hidden");
			$(".complete").removeClass("hidden");
			$("#next").html('next');

		} if (state == 4) {
			
		
		} if (state == 5) {
			console.log(5)

		}

	}
});




var select_card = document.querySelectorAll(".select");

var title = document.getElementById("title");
var price = document.getElementById("price");

var selected=2;



var reset = ()=>{
  
select_card.forEach((k)=>{
  
 k.setAttribute("data-selected", "false");
})
}

select_card.forEach((a,i)=>{
  
  a.addEventListener("click",(e)=>{
     reset();
   a.setAttribute("data-selected", "true")
    selected=i+1;
    
    
    
    
  })
})



var select_btn = document.querySelector(".select-btn");

var container = document.querySelector(".container");


var exit_btn = document.querySelector(".exit-btn");







// OLD SOLUTION USING JQUERY:
// Applied globally on all textareas with the "autoExpand" class

$(document)
    .one('focus.autoExpand', 'textarea.autoExpand', function(){
        var savedValue = this.value;
        this.value = '';
        this._baseScrollHeight = this.scrollHeight;
        this.value = savedValue;
    })
    .on('input.autoExpand', 'textarea.autoExpand', function(){
        var minRows = this.getAttribute('data-min-rows')|0, rows;
        this.rows = minRows;
        rows = Math.ceil((this.scrollHeight - this.baseScrollHeight) / 16);
        this.rows = minRows + rows;
    });