import React, { useEffect, useMemo, useRef, useState } from 'react';
import styled from 'styled-components';
import ReactQuill, { Quill } from 'react-quill';
import ImageResize from '@looop/quill-image-resize-module-react';
import 'react-quill/dist/quill.snow.css';
import { useProjectCreateMemory } from '../../../component/context/ProjectCreateContext';
import { useParams } from 'react-router';
Quill.register('modules/ImageResize', ImageResize);


const StyledCreateDateplanDiv = styled.div`
    & .inner {
        width: 1200px;
        margin: 0 auto;
        padding: 40px 0;
        & > dl {
            display: flex;
            gap: 60px;
            & > dt {
                width: 300px;
                font-size: 16px;
                font-weight: 500;
                color: #333;
                &::after {
                    content: " *";
                    color: red;
                }
            }
            & > dd {
                display: flex;
                flex-direction: column;
                width: calc(100% - 300px - 60px);
                gap: 20px;
                & .item {
                    display: flex;
                    flex-direction: column;
                    gap: 5px;
                    flex: 1;
                    & > dt {
                        font-size: 13px;
                        color: #333;
                    }
                }
            }
        }
    }
    & .quill {
        background-color: #fff;
        & .ql-container {
            max-height: 350px;
            overflow: auto;
        }
    }
`;
const formats = [
    'font', 'header', 'bold', 'italic', 'underline', 'strike', 'blockquote', 'list', 'bullet', 'indent', 'link', 'align', 'color', 'background', 'size', 'h1', 'image', 'link'
];

const ProjectDateplanCreate = () => {

    const { headerFormVo, setHeaderFormVo, setIsProjectInputChange, setDataFrom, setProjectCreateData, projectCreateData } = useProjectCreateMemory(); // 컨텍스트 데이터
    const { projectNo } = useParams(); // 파라미터

    // 컨텍스트 데이터에 프로젝트 넘버 저장
    useEffect(() => {
        setProjectCreateData({
            ...projectCreateData,
            'mainVo': {
                'no': projectNo,
            },
        })
        setHeaderFormVo({
            ...headerFormVo,
            'no': projectNo,
        });
    }, []);

    // 에디터 접근을 위한 ref
    const quillRefs = [
        useRef(),
        useRef(),
        useRef(),
        useRef(),
        useRef(),
    ];

    // 이미지 리사이즈 모듈을 useEffect 내에서 초기화
    useEffect(() => {
        Quill.register('modules/ImageResize', ImageResize);
    }, []);

    // image를 서버로 전달하는 과정
    const imageHandler = () => {

        // input file DOM 만들기
        const input = document.createElement('input');
        input.setAttribute('type', 'file');
        input.setAttribute('accept', 'image/*');
        input.click();

        input.addEventListener('change', () => {
            const file = input.files[0];
            
            const formData = new FormData();
            formData.append('img', file);

            let imgUrl = null; // url 담을 변수
            fetch('http://localhost:8889/gamepound/project/save/image', {
                    method: 'post',
                    body: formData,
            })
            .then(resp => resp.json())
            .then(data => {
                if(data.msg === 'good'){
                    imgUrl = data.fileUrl;

                    // quillRefs 배열에 있는 모든 참조에 대해 이미지 삽입 작업 수행
                    quillRefs.forEach((quillRef) => {
                        const editor = quillRef.current?.getEditor(); // 안전하게 에디터 객체 가져오기
                        const range = editor?.getSelection(); // 안전하게 range 객체 가져오기

                        // range 객체가 null이 아닌 경우에만 이미지 삽입
                        if (editor && range) {
                        editor.insertEmbed(range.index, 'image', imgUrl);
                        }
                    });
                
                } else {
                    throw new Error();
                }
            })
            .catch((e) => {
                alert(e);
            })
            ;

        });

    };

    // quill state
    const [descriptionValues, setDescriptionValues] = useState();
    const [budgetValues, setBudgetValues] = useState();
    const [scheduleValues, setScheduleValues] = useState();
    const [teamValues, setTeamValues] = useState();
    const [itemValues, setItemValues] = useState();

    
    // 각 상태를 업데이트 하는 함수
    const updateProjectData = (fieldName, value) => {
        setHeaderFormVo({
            ...headerFormVo,
            [fieldName]: value,
        });
    };
    // console.log('headerFormVo', headerFormVo);

    const modules = useMemo(() => {
        return {
            toolbar: {
                container: [
                    [{ size: ['small', false, 'large', 'huge'] }],
                    [{'align': []}, {'color': []}, {'background': []}],
                    ['bold', 'italic', 'underline', 'strike'],
                    [{'header': [1, 2, 3, false]}],
                    [{'list': 'ordered'}, {'list': 'bullet'}, {'indent': '-1'}, {'indent': '+1'}],
                    ['link'],
                    ['image'],
                ],
                handlers: {
                    image: imageHandler,
                },
            },
            ImageResize: {
                displaySize: true,
                modules: ['Resize', 'DisplaySize']
            }
        };
    }, []);

    return (
        <StyledCreateDateplanDiv>
            <div className="inner">
                <dl>
                    <dt>프로젝트 계획</dt>
                    <dd>
                        <dl className='item'>
                            <dt>프로젝트 소개</dt>
                            <dd>
                                <ReactQuill
                                    ref={quillRefs[0]}
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={descriptionValues}
                                    onChange={(content) => updateProjectData("description", content)}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 예산</dt>
                            <dd>
                                <ReactQuill
                                    ref={quillRefs[1]}
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={budgetValues}
                                    onChange={(content) => setBudgetValues(content)}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 일정</dt>
                            <dd>
                                <ReactQuill
                                    ref={quillRefs[2]}
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={scheduleValues}
                                    onChange={(content) => setScheduleValues(content)}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 팀 소개</dt>
                            <dd>
                                <ReactQuill
                                    ref={quillRefs[3]}
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={teamValues}
                                    onChange={(content) => setTeamValues(content)}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 선물 소개</dt>
                            <dd>
                                <ReactQuill
                                    ref={quillRefs[4]}
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={itemValues}
                                    onChange={(content) => setItemValues(content)}
                                />
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreateDateplanDiv>
    );
};

export default ProjectDateplanCreate;