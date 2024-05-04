const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');
allSideMenu.forEach(item=> {
    const li = item.parentElement;
    item.addEventListener('click',function (){
        allSideMenu.forEach(i=> {
            i.parentElement.classList.remove('active');
        })
        li.classList.add('active');
    })
});

const menuBar = document.querySelector('#content nav .bx.bx-menu');
const sidebar = document.getElementById('sidebar');
menuBar.addEventListener(('click'), function(){
    sidebar.classList.toggle('hide');
});



// Hàm để tạo danh sách tháng
function createMonthOptions() {
    $('#content main .head-title .filter .monthFilter').empty();
    var months = [
        { month: 1, name: "Tháng 1" }, { month: 2, name: "Tháng 2" }, { month: 3, name: "Tháng 3" },
        { month: 4, name: "Tháng 4" }, { month: 5, name: "Tháng 5" }, { month: 6, name: "Tháng 6" },
        { month: 7, name: "Tháng 7" }, { month: 8, name: "Tháng 8" }, { month: 9, name: "Tháng 9" },
        { month: 10, name: "Tháng 10" }, { month: 11, name: "Tháng 11" }, { month: 12, name: "Tháng 12" }
    ];
    for (var i = 0; i < months.length; i++) {
        $('#content main .head-title .filter .monthFilter').append($('<option>', {
            value: months[i].month,
            text: months[i].name
        }));
    }
}

// Hàm để tạo danh sách năm
function createYearOptions() {
    var currentYear = new Date().getFullYear();
    for (var year = currentYear; year >= currentYear - 5; year--) {
        $('#content main .head-title .filter .yearFilter').append($('<option>', {
            value: year,
            text: year
        }));
    }
}

// Khi thay đổi bộ lọc loại
$('#content main .head-title .filter .filterType').change(function() {
    var selectedValue = $(this).val();
    if (selectedValue === 'month') {
        // Hiển thị bộ lọc tháng và năm
        $('#content main .head-title .filter .monthFilter').show();
        $('#content main .head-title .filter .yearFilter').show();
        createMonthOptions();
        createYearOptions();
    } else if (selectedValue === 'year') {
        // Ẩn bộ lọc tháng và hiển thị chỉ bộ lọc năm
        $('#content main .head-title .filter .monthFilter').hide();
        $('#content main .head-title .filter .yearFilter').show();
        createYearOptions();
    }
});


// Ban đầu, hiển thị bộ lọc tháng và năm
createMonthOptions();
createYearOptions();





