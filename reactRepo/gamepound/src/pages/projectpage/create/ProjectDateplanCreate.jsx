import React, { useMemo, useState } from 'react';
import styled from 'styled-components';
import ReactQuill, { Quill } from 'react-quill';
import ImageResize from '@looop/quill-image-resize-module-react';
import 'react-quill/dist/quill.snow.css';

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
    }
`;
const formats = [
    'font', 'header', 'bold', 'italic', 'underline', 'strike', 'blockquote', 'list', 'bullet', 'indent', 'link', 'align', 'color', 'background', 'size', 'h1', 'image', 'link'
];
Quill.register('modules/ImageResize', ImageResize);

const ProjectDateplanCreate = () => {
    const [descriptionValues, setDescriptionValues] = useState();
    const [budgetValues, setBudgetValues] = useState();
    const [scheduleValues, setScheduleValues] = useState();
    const [teamValues, setTeamValues] = useState();
    const [itemValues, setItemValues] = useState();
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
                ImageResize: { modules: ['Resize'] },
            },
        };
    }, []);

    //image를 서버로 전달하는 과정
    // const ImageHandler = () => {
    //     //input type= file DOM을 만든다.
    //     const input = document.createElement("input");
    //     input.setAttribute("type", "file");
    //     input.setAttribute("accept", "image/*");
    //     input.click(); //toolbar 이미지를 누르게 되면 이 부분이 실행된다.
    //     /*이미지를 선택하게 될 시*/
    //     input.onchange = async () => {
    //     /*이미지 선택에 따른 조건을 다시 한번 하게 된다.*/
    //     const file: any = input.files ? input.files[0] : null;
    //     /*선택을 안하면 취소버튼처럼 수행하게 된다.*/
    //     if (!file) return;
    //     /*서버에서 FormData형식으로 받기 때문에 이에 맞는 데이터형식으로 만들어준다.*/
    //     const formData = new FormData();
    //     formData.append("profile", file);
    //     /*에디터 정보를 가져온다.*/
    //     let quillObj = quillRef.current?.getEditor();
    //     /*에디터 커서 위치를 가져온다.*/
    //     const range = quillObj?.getSelection()!;
    //     try {
    //         /*서버에다가 정보를 보내준 다음 서버에서 보낸 url을 imgUrl로 받는다.*/
    //         const res = await axios.post(
    //         "api주소",
    //         formData
    //         );
    //         const imgUrl = res.data;
    //         /*에디터의 커서 위치에 이미지 요소를 넣어준다.*/
    //         quillObj?.insertEmbed(range.index, "image", `${imgUrl}`);
    //     } catch (error) {
    //         console.log(error);
    //     }
    //     };
    // };

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
                                    theme="snow"
                                    modules={modules}
                                    formats={formats}
                                    value={descriptionValues}
                                    onChange={(content) => setDescriptionValues(content)}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 예산</dt>
                            <dd>
                                <ReactQuill
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