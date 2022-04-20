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

// 이전버튼
$("#btn-prev").click(() => {
    page--;
    $("#post-box").empty();
    let keyword = $("#keyword").val(); // 키워드 가지고 가야함
    list(keyword);
});

// 다음버튼 이벤트
$("#btn-next").click(() => {
    page++;
    $("#post-box").empty();
    let keyword = $("#keyword").val();
    list(keyword);
});

// 검색버튼 이벤트
$("#btn-search").click(() => {
    page = 0; // 페이지 초기화 검색한 페이지가 0번!
    keyword = $("#keyword").val();
    $("#post-box").empty();
    list(keyword);
});

let page = 0;
let keyword = $("#keyword").val(""); // 초기화
let boardNo = $("#board-no").val();
console.log(boardNo);

// 검색
async function list(keyword) {
    // alert(page);
    let response = await fetch(`/s/api/post/list?page=${page}&keyword=${keyword}&boardNo=${boardNo}`);
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

    return `<a href="/s/post/${post.id}" class="card my_post_list_box">
                <div class="clubbody">
                    <div class="boardtitle">${post.title}</div>
                    <div class="boardcontent">${post.content}</div>
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