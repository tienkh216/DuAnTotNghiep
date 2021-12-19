/* JS Document */

/******************************

 [Table of Contents]

 1. Vars and Inits
 2. Set Header
 3. Init Menu
 4. Init Favorite
 5. Init Fix Product Border
 6. Init Isotope Filtering
 7. Init Price Slider
 8. Init Checkboxes



 ******************************/
setTimeout(()=>{
	jQuery(document).ready(function($)
{
	"use strict";

	/*

	1. Vars and Inits

	*/

	var header = $('.header');
	var topNav = $('.top_nav')
	var mainSlider = $('.main_slider');
	var hamburger = $('.hamburger_container');
	var menu = $('.hamburger_menu');
	var menuActive = false;
	var hamburgerClose = $('.hamburger_close');
	var fsOverlay = $('.fs_menu_overlay');

	setHeader();

	$(window).on('resize', function()
	{
		initFixProductBorder();
		setHeader();
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	initMenu();
	initFavorite();
	initFixProductBorder();
	initIsotopeFiltering();
	initPriceSlider();
	initCheckboxes();
	initSearch();
	/*

	2. Set Header

	*/

	function setHeader()
	{
		if(window.innerWidth < 992)
		{
			if($(window).scrollTop() > 100)
			{
				header.css({'top':"0"});
			}
			else
			{
				header.css({'top':"0"});
			}
		}
		else
		{
			if($(window).scrollTop() > 100)
			{
				header.css({'top':"-50px"});
			}
			else
			{
				header.css({'top':"0"});
			}
		}
		if(window.innerWidth > 991 && menuActive)
		{
			closeMenu();
		}
	}

	/*

	3. Init Menu

	*/

	function initMenu()
	{
		if(hamburger.length)
		{
			hamburger.on('click', function()
			{
				if(!menuActive)
				{
					openMenu();
				}
			});
		}

		if(fsOverlay.length)
		{
			fsOverlay.on('click', function()
			{
				if(menuActive)
				{
					closeMenu();
				}
			});
		}

		if(hamburgerClose.length)
		{
			hamburgerClose.on('click', function()
			{
				if(menuActive)
				{
					closeMenu();
				}
			});
		}

		if($('.menu_item').length)
		{
			var items = document.getElementsByClassName('menu_item');
			var i;

			for(i = 0; i < items.length; i++)
			{
				if(items[i].classList.contains("has-children"))
				{
					items[i].onclick = function()
					{
						this.classList.toggle("active");
						var panel = this.children[1];
						if(panel.style.maxHeight)
						{
							panel.style.maxHeight = null;
						}
						else
						{
							panel.style.maxHeight = panel.scrollHeight + "px";
						}
					}
				}
			}
		}
	}

	function openMenu()
	{
		menu.addClass('active');
		// menu.css('right', "0");
		fsOverlay.css('pointer-events', "auto");
		menuActive = true;
	}

	function closeMenu()
	{
		menu.removeClass('active');
		fsOverlay.css('pointer-events', "none");
		menuActive = false;
	}

	/*

	4. Init Favorite

	*/

	function initFavorite()
	{
		if($('.favorite').length)
		{
			var favs = $('.favorite');

			favs.each(function()
			{
				var fav = $(this);
				var active = false;
				if(fav.hasClass('active'))
				{
					active = true;
				}

				fav.on('click', function()
				{
					if(active)
					{
						fav.removeClass('active');
						active = false;
					}
					else
					{
						fav.addClass('active');
						active = true;
					}
				});
			});
		}
	}

	/*

    5. Init Fix Product Border

    */

	function initFixProductBorder()
	{
		if($('.product_filter').length)
		{
			var products = $('.product_filter:visible');
			var wdth = window.innerWidth;

			// reset border
			products.each(function()
			{
				$(this).css('border-right', 'solid 1px #e9e9e9');
			});

			// if window width is 991px or less

			if(wdth < 480)
			{
				for(var i = 0; i < products.length; i++)
				{
					var product = $(products[i]);
					product.css('border-right', 'none');
				}
			}

			else if(wdth < 576)
			{
				if(products.length < 5)
				{
					var product = $(products[products.length - 1]);
					product.css('border-right', 'none');
				}
				for(var i = 1; i < products.length; i+=2)
				{
					var product = $(products[i]);
					product.css('border-right', 'none');
				}
			}

			else if(wdth < 768)
			{
				if(products.length < 5)
				{
					var product = $(products[products.length - 1]);
					product.css('border-right', 'none');
				}
				for(var i = 2; i < products.length; i+=3)
				{
					var product = $(products[i]);
					product.css('border-right', 'none');
				}
			}

			else if(wdth < 992)
			{
				if(products.length < 5)
				{
					var product = $(products[products.length - 1]);
					product.css('border-right', 'none');
				}
				for(var i = 2; i < products.length; i+=3)
				{
					var product = $(products[i]);
					product.css('border-right', 'none');
				}
			}

			//if window width is larger than 991px
			else
			{
				if(products.length < 5)
				{
					var product = $(products[products.length - 1]);
					product.css('border-right', 'none');
				}
				for(var i = 3; i < products.length; i+=4)
				{
					var product = $(products[i]);
					product.css('border-right', 'none');
				}
			}
		}
	}

	/*

    6. Init Isotope Filtering

    */

	function initIsotopeFiltering()
	{
		var sortTypes = $('.type_sorting_btn');
		var sortNums = $('.num_sorting_btn');
		var sortTypesSelected = $('.sorting_type .item_sorting_btn is-checked span');
		var filterButton = $('.filter_button');

		if($('.product-grid').length)
		{
			$('.product-grid').isotope({
				itemSelector: '.product-item',
				getSortData: {
					price: function(itemElement)
					{
						var priceEle = $(itemElement).find('.product_price').text().replace( '$', '' );
						return parseFloat(priceEle);
					},
					name: '.product_name'
				},
				animationOptions: {
					duration: 750,
					easing: 'linear',
					queue: false
				}
			});


			$('.grid_sorting_button').click(function()
			{
				// putting border fix inside of setTimeout because of the transition duration
				setTimeout(function()
				{
					initFixProductBorder();
				},500);


				$('.grid_sorting_button.active i').addClass('dis');
				$('.grid_sorting_button.active').removeClass('active');




				$(this).addClass('active');
				$('.grid_sorting_button.active i').removeClass('dis');







				var selector = $(this).attr('data-filter');
				$('.product-grid').isotope({
					filter: selector,
					animationOptions: {
						duration: 750,
						easing: 'linear',
						queue: false
					}
				});


				return false;
			});
			// Short based on the value from the sorting_type dropdown
			sortTypes.each(function()
			{
				$(this).on('click', function()
				{
					$('.type_sorting_text').text($(this).text());
					var option = $(this).attr('data-isotope-option');
					option = JSON.parse( option );
					$('.product-grid').isotope( option );
				});
			});

			// Show only a selected number of items
			sortNums.each(function()
			{
				$(this).on('click', function()
				{
					var numSortingText = $(this).text();
					var numFilter = ':nth-child(-n+' + numSortingText + ')';
					$('.num_sorting_text').text($(this).text());
					$('.product-grid').isotope({filter: numFilter });
				});
			});

			// Filter based on the price range slider
			filterButton.on('click', function()
			{
				$('.product-grid').isotope({
					filter: function()
					{
						var priceRange = $('#amount').val();
						var priceMin = parseFloat(priceRange.split('-')[0].replace('VNĐ', ''));
						var priceMax = parseFloat(priceRange.split('-')[1].replace('VNĐ', ''));
						var itemPrice = $(this).find('.price').clone().children().remove().end().text().replace( 'VNĐ', '' );

						return (itemPrice > priceMin) && (itemPrice < priceMax);
					},
					animationOptions: {
						duration: 750,
						easing: 'linear',
						queue: false
					}
				});
			});
		}
	}


	function initPriceSlider()
	{
		$( "#slider-range" ).slider(
			{
				range: true,
				min: 50000,
				max: 3000000,
				values: [ 50000, 3000000 ],
				slide: function( event, ui )
				{

					console.log(ui.values);
					$( "#amount" ).val(  ui.values[ 0 ] + " VNĐ"+ " - " + ui.values[ 1 ] + " VNĐ");
				}
			});

		console.log($( "#amount" ).val);
		$( "#amount" ).val(  $( "#slider-range" ).slider( "values", 0 )  + " VNĐ" + " - " + $( "#slider-range" ).slider( "values", 1 ) + " VNĐ" );
	}



	//abâc

// init Isotope
	var initial_items = 12;
	var next_items = 6;
	var $grid = $('#grid').isotope({
		itemSelector: '.product-item',
		layoutMode: 'masonry',
		stamp: '.product-item--static'
	});



	function showNextItems(pagination) {
		var itemsMax = $('.visible_item').length;
		var itemsCount = 0;
		$('.visible_item').each(function () {
			if (itemsCount < pagination) {
				$(this).removeClass('visible_item');
				itemsCount++;
			}
		});
		if (itemsCount >= itemsMax) {
			$('#showMore').hide();
		}
		$grid.isotope('layout');
	}
// function that hides items when page is loaded
	function hideItems(pagination) {
		var itemsMax = $('.product-item').length;
		var itemsCount = 0;
		$('.product-item').each(function () {
			if (itemsCount >= pagination) {
				$(this).addClass('visible_item');
			}
			itemsCount++;
		});
		if (itemsCount < itemsMax || initial_items >= itemsMax) {
			$('#showMore').hide();
		}
		$grid.isotope('layout');
	}
	$('#showMore').on('click', function (e) {
		e.preventDefault();
		showNextItems(next_items);
	});
	hideItems(initial_items);




		function initSearch(){


			var qsRegex;

			var $grid = $('.product-grid').isotope({
				itemSelector: '.product-item',
				layoutMode: 'fitRows',
				filter: function() {
					return qsRegex ? $(this).text().match( qsRegex ) : true;
				}
			});


			var $quicksearch = $('#search').keyup( debounce( function() {
				qsRegex = new RegExp( $quicksearch.val(), 'gi' );
				$grid.isotope();
			}, 200 ) );


			function debounce( fn, threshold ) {
				var timeout;
				threshold = threshold || 100;
				return function debounced() {
					clearTimeout( timeout );
					var args = arguments;
					var _this = this;
					function delayed() {
						fn.apply( _this, args );
					}
					timeout = setTimeout( delayed, threshold );
				};
			}

		}

	function initCheckboxes()
	{
		if($('.checkboxes li').length)
		{
			var boxes = $('.checkboxes li');

			boxes.each(function()
			{
				var box = $(this);

				box.on('click', function()
				{
					if(box.hasClass('active'))
					{
						box.find('i').removeClass('fa-square');
						box.find('i').addClass('fa-square-o');
						box.toggleClass('active');
					}
					else
					{
						box.find('i').removeClass('fa-square-o');
						box.find('i').addClass('fa-square');
						box.toggleClass('active');
					}
					// box.toggleClass('active');
				});
			});

			if($('.show_more').length)
			{
				var checkboxes = $('.checkboxes');

				$('.show_more').on('click', function()
				{
					checkboxes.toggleClass('active');
				});
			}
		};
	}
});
	}, 100);