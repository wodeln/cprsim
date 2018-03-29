// 文件上传
jQuery(function() {
    var $ = jQuery,
        $list = $('#thelist'),
        $btn = $('#ctlBtn'),
        state = 'pending',
        uploader;

    uploader = WebUploader.create({

        // 不压缩image
        resize: false,

        // swf文件路径
        swf: '/js/Uploader.swf',

        // 文件接收服务端。
        server: '/student/import_excel',

        duplicate: true,

        fileNumLimit: 1,

        accept: {
            title: 'Office',
            extensions: 'xls,xlsx'
        },
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker'
    });

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        $list.append( '<div id="' + file.id + '" class="item">' +
            '<h4 class="info">' + file.name + '</h4>' +
            '<p class="state">等待上传...</p>' +
        '</div>' );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<div class="progress progress-striped active">' +
              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
              '</div>' +
            '</div>').appendTo( $li ).find('.progress-bar');
        }

        $li.find('p.state').text('上传中');

        $percent.css( 'width', percentage * 100 + '%' );
    });

    uploader.on( 'uploadSuccess', function( file,response ) {
        console.log(response);
        $( '#'+file.id ).find('p.state').text('已上传');
    });

    uploader.on( 'uploadError', function( file ) {
        $( '#'+file.id ).find('p.state').text('上传出错');
    });

    uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').fadeOut();
    });

    uploader.on("uploadAccept", function( file, data){
        // console.log("uploadAccept:"+data);
        var res = true;
        if ( data.success=="0") {
            //data即为服务器返回的信息
            // 通过return false来告诉组件，此文件上传有错。
           res = false;
        }else {
            var divEnd = '</div>';

            var spanStartW12 = '<span class="col-sm-2 w12 pr0">';
            var spanStartW18 = '<span class="col-sm-2 w18 pr0">';
            var spanStartW9 = '<span class="col-sm-2 w9 pr0">';
            var spanStartW30 = '<span class="col-sm-2 w30 pr0">';
            var spanEnd = '</span>';
            var html = "";

            var optStr = "<option>选择班级</option>";
            $.each(data["students"], function(i, v) {
                var spanStartT3 = '<span class="col-sm-12 pl0 mt3" id="fst' + i + '">';
                var spanStartT = '<span class="col-sm-12 pl0" id="fs' + i + '">';
                var divStart = '<div class="form-group col-sm-12 pl0 i'+i%2+'" id="' + i + '">';

                var inputName = spanStartW12 + '<input placeholder="姓名 例：小明" name="studentName[]" id="name' + i + '" id_sort="' + i + '" value="'+v["studentName"]+'" class="form-control student_name" type="text">' + spanEnd;
                var inputCode = spanStartW9 + '<input placeholder="学号" name="studentCode[]" id="code' + i + '" id_sort="' + i + '" value="'+v["studentCode"]+'" class="form-control student_name" type="text">' + spanEnd;
                var inputProvince = spanStartW9 + '<input placeholder="省份" name="province[]" id="province'+ i +'" id_sort="' + i + '" value="'+v["hProvince"]+'" class="form-control province" type="text">' + spanEnd;
                var inputDistrict = spanStartW9 + '<input placeholder="区县" name="district[]" id="district'+ i +'" id_sort="' + i + '" value="'+v["hDistrict"]+'" class="form-control district" type="text">' + spanEnd;
                var inputAddress = spanStartW30 + '<input placeholder="户口地址" name="address[]" id="address'+ i +'" id_sort="' + i + '" value="'+v["hAddress"]+'" class="form-control address" type="text">' + spanEnd;
                var contactName = spanStartW9 + '<input placeholder="联系人" name="contactName[]" id="contact_name'+ i +'" id_sort="' + i + '" value="'+v["contactName"]+'" class="form-control contact_name" type="text">' + spanEnd;
                var contactNum = spanStartW12 + '<input placeholder="联系电话" name="contactNum[]" id="contact_num'+ i +'" id_sort="' + i + '" value="'+v["contactNum"]+'" class="form-control contact_num" type="text">' + spanEnd;
                var nowAddress = spanStartW30 + '<input placeholder="现居地址" name="nowAddress[]" id="now_address'+ i +'" id_sort="' + i + '" value="'+v["nowAddress"]+'" class="form-control now_address" type="text">' + spanEnd;
                var inputCard = spanStartW18 + '<input name="studentCardNum[]" onkeyup="checkIdCard(this)" placeholder="身份证号码" data-mask="999 999 9999 9999 9999" id="card' + i + '" id_sort="' + i + '" value="'+v["studentCardNum"]+'" class="form-control student_card_num" type="text">' + spanEnd;
                var inputAge = spanStartW9 + '<input name="studentAge[]" placeholder="年龄" id="age' + i + '" id_sort="' + i + '" value="'+v["studentAge"]+'" class="form-control student_age" type="text">' + spanEnd;
                var inputSex = spanStartW9 + '<select name="studentSex[]" id="sex' + i + '" id_sort="' + i + '" class="form-control sex"> <option value="">性别</option> <option value="1">男</option> <option value="2">女</option> </select>' + spanEnd;
                var inputYear = spanStartW12 + '<input name="classYear[]" id="year' + i + '" id_sort="' + i + '" class="form-control class_year" value="${cur_year}" type="text" required>' + spanEnd;
                var options = $("#opt_str").html();
                var inputClass = spanStartW12 + '<select name="classId[]" id="clazz' + i + '" id_sort="' + i + '" class="form-control" required><option value="">选择班级</option>' + options + '</select>' + spanEnd;
                var inputAliId = spanStartW18 + '<input placeholder="学籍副号" name="studentAliId[]" id="ali' + i + '" id_sort="'+i+'" value="'+v["studentAliId"]+'" class="form-control student_name" type="text">' + spanEnd;
                var del = '<span class="col-sm-1 w3" id="d' + i + '" id_sort="' + i + '" onclick="del_item(this)"><i class="fa fa-close text-danger"></i></span>';
                var top = spanStartT3 + inputName + inputCode + inputYear + inputClass + inputCard + inputAge + inputSex + inputAliId + spanEnd;
                var bottom = spanStartT + inputProvince + inputDistrict + inputAddress + contactName + contactNum + nowAddress + spanEnd;
                html += divStart + top + bottom + del + divEnd;
            });
            $("#viladate_form").html(html);
        }
        return res;
    });

    uploader.on( 'all', function( type ) {
        if ( type === 'startUpload' ) {
            state = 'uploading';
        } else if ( type === 'stopUpload' ) {
            state = 'paused';
        } else if ( type === 'uploadFinished' ) {
            state = 'done';
        }

        if ( state === 'uploading' ) {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on( 'click', function() {
        if ( state === 'uploading' ) {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
});


// 图片上传demo
jQuery(function() {
    var $ = jQuery,
        $list = $('#fileList'),
        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,

        // Web Uploader实例
        uploader;

    // 初始化Web Uploader
    uploader = WebUploader.create({

        // 自动上传。
        auto: true,

        // swf文件路径
        swf: '/js/Uploader.swf',

        // 文件接收服务端。
        server: 'http://webuploader.duapp.com/server/fileupload.php',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',

        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                '</div>'
                ),
            $img = $li.find('img');

        $list.append( $li );

        // 创建缩略图
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file ) {
        $( '#'+file.id ).addClass('upload-state-done');
    });

    // 文件上传失败，现实上传出错。
    uploader.on( 'uploadError', function( file ) {
        var $li = $( '#'+file.id ),
            $error = $li.find('div.error');

        // 避免重复创建
        if ( !$error.length ) {
            $error = $('<div class="error"></div>').appendTo( $li );
        }

        $error.text('上传失败');
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });
});