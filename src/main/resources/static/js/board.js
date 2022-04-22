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

<<<<<<< HEAD
=======
let page = 0;
let keyword = $("#keyword").val(""); // 초기화
let boardNo = $("#board-no").val();
// console.log(boardNo);
>>>>>>> 495b2c9b1f024d741f9084589aad85fe708dee3b

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
<<<<<<< HEAD
}
=======

    return `<a href="/s/post/${post.id}" class="card my_post_list_box">
                <div class="clubbody my_p_md_2">
                    <div class="boardtitle my_mb_sm_2">${post.title}</div>
                    <div class="boardcontent my_mb_sm_2">${post.content}</div>
                    <div class="boardbottom">
                        <div class="bottom">
                            <time>${post.createDate}</time>
                            <div class="secret">${post.user.username}</div>
                        </div>
                        <div class="vote_comment">
                            <div class="clubvote">
                                <li class="vote active">${post.likeCount}</li>
                            </div>
                            <div class="clubcomment">
                                <li class="comment active">${commentCount}</li>
                            </div>
                        </div>
                    </div>
                </div>
            </a>`;
}

function pagingDisabled(responseParse) {
    if (responseParse.first == true) {
        $("#li-prev").addClass("my_hidden");
        $("#li-next").removeClass("my_hidden");
        $("#my_post_search").removeClass("my_hidden");
    } else if (responseParse.last == true) {
        $("#li-prev").removeClass("my_hidden");
        $("#li-next").addClass("my_hidden");
        $("#my_post_search").addClass("my_hidden");
    } else {
        $("#li-prev").removeClass("my_hidden");
        $("#li-next").removeClass("my_hidden");
        $("#my_post_search").addClass("my_hidden");
    }
}

list("");
>>>>>>> 495b2c9b1f024d741f9084589aad85fe708dee3b
