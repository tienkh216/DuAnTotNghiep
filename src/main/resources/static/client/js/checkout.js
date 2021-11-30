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
	if (state <= stateMax) {
		next();

		state += 1;

		// mở khoá nút back
		$("#back").removeClass("disabled");

		// add màu xanh cho thanh bar
		$(".nConfirm" + state).each(function () {
			$(this).addClass("done");
		});

		// Progress bar animation
		var pBar = (state / stateMax) * 125;
		$(".pBar").css("width", `${pBar}%`);


		if (state == 1) {
			$(".information").removeClass("hidden");
			$(".address").addClass("hidden");

		} if (state == 2) {
			$(".address").removeClass("hidden");
			$(".review").addClass("hidden");

		} if (state == 3) {
			$(".review").removeClass("hidden");
			$(".payment").addClass("hidden");

		}
		// đổi nút next thành finish
		if (state == 4) {
			$(".payment").removeClass("hidden");
			$(".complete").addClass("hidden");
			$("#next").html('<b>Finish</b>');
			

		}

		//// sự kiện gửi form lên servẻ
		if (state == 5) {
		
			alert("gửi form lên server")

		}

	}
});

$("#back").click(function () {
	if (state >= 0) {
		back();
		$("#next").removeClass("disabled");
		$(".nConfirm" + state).each(function () {
			$(this).removeClass("done");
		});
		state -= 1;
		var pBar = (state / stateMax) * 125;
		$(".pBar").css("width", `${pBar}%`);

		if (state == 0) {
			$("#back").addClass("disabled");
			console.log(0)
		}

		if (state == 1) {
			console.log(1)

		} if (state == 2) {
			console.log(2)

		} if (state == 4) {
			console.log(4)

		} if (state == 5) {
			console.log(5)

		}
		if (state == 3) {
			$("#next").html('next');
			console.log(3)
		}
	}
});
