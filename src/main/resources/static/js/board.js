// 글쓰기 폼 열기 버튼 이벤트
$(".club_top").click(() => {
    // $("#card-box").append(postWrite());
    writeForm();
});

// 글쓰기 버튼 이벤트
$("#submit").click(() => {
    write();
});

// 익명 체크 이벤트
$("#anony").click(() => {
    $("#anony").toggleClass("my_btn_active");
});

// 글쓰기 페이지 열기
function writeForm() {
    if ($("#write-form").hasClass("my_hidden") == true) {
        $("#write-form").removeClass("my_hidden");
        $(".club_top").addClass("my_hidden");
    }
}

// 글쓰기
async function write() {

    let writeDto = {
        title: $("#title").val(),
        content: $("#content").val(),
        boardNo: $("#board-no").val(),
        likeCount: 0,
        commentCount: 0,
        scrapCount: 0,
        anonyCheck: $("#anony").hasClass("my_btn_active"),
        hashTag: null
    }

    let response = await fetch("/s/post", {
        method: "POST",
        body: JSON.stringify(writeDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });

    let responseParse = await response.json();

    if (responseParse == 1) {
        let boardNo = $("#board-no").val();
        location.href = "/s/board/" + boardNo;
    } else {
        alert("글쓰기에 실패하였습니다.");
    }
}


// 검색버튼 이벤트
$("#btn-search").click(() => {
    page = 0; // 페이지 초기화 검색한 페이지가 0번!
    keyword = $("#keyword").val();
    $("#post-box").empty();
    list(keyword);
});

// 검색
async function list(keyword) {
    // alert(page);
    let response = await fetch(`/s/board/${boardNo}?keyword=${keyword}`);
    let responseParse = await response.json();

    if (response.status === 200) {
        pagingDisabled(responseParse);
        responseParse.content.forEach((post) => {
            $("#post-box").append(postList(post));
        });
    } else {
        alert("잘못된 요청입니다.");
    }
}

function postList(post) {
    if (post.anonyCheck == true) {
        post.user.username = "익명";
    }

    let commentCount = post.comments.length;
}

