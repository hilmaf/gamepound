import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useHeaderMemory } from '../../../component/context/HeaderContext';

const StyledCreateBasicDiv = styled.div`
    padding: 40px 0;
    & .contentDiv {
        width: 1200px;
        margin: 0 auto;
        & input,
        & select {
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ddd;
            padding: 7px 15px;
            border-radius: 5px;
            &:hover,
            &:focus {
                border-color: #333;
                outline: none;
            }
        }
        & select {
            color: #999;
        }
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
                & .item.img {
                    & dd {
                        display: flex;
                        justify-content: flex-start;
                        align-items: flex-start;
                        gap: 20px;
                        & .img {
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            width: 200px;
                            height: 133px;
                            overflow: hidden;
                            border: 1px solid #ddd;
                            & img {
                                min-height: 100%;
                                max-height: 100%;
                                max-width: 100%;
                            }
                        }
                        & input {
                            position: absolute;
                            left: -9999em;
                        }
                        & label {
                            display: block;
                            padding: 6px 15px;
                            border-radius: 5px;
                            background-color: #333;
                            font-size: 15px;
                            color: #fff;
                            cursor: pointer;
                        }
                    }
                }
            }
        }
        & > dl + dl {
            margin-top: 40px;
        }
    }
`;

const ProjectBasicCreate = () => {

    const { updatePageType } = useHeaderMemory();
    const [formVo, setFormVo] = useState({});

    // header type
    useEffect(() => {
        updatePageType('createMain');
    }, [updatePageType]);

    // 데이터 불러오기
    useEffect(() => {
        fetch('', {})
        .then()
        .then()
        ;
    }, []);

    // 이미지 미리보기
    const handleImgCreate = (e) => {
        const imgInp = e.target.parentNode.querySelector('input');
        const imgDiv = e.target.parentNode.querySelector('.img');
        // 파일이 선택되었는지 확인
        if (imgInp.files.length > 0) {
            const file = imgInp.files[0];

            // FileReader 객체를 사용하여 파일 읽기
            const reader = new FileReader();
            reader.onload = function (e) {
                // 이미지를 보여주는 div에 이미지 추가
                const imgElement = document.createElement('img');
                imgElement.src = e.target.result;
                imgDiv.innerHTML = ''; // 이전에 추가된 이미지 삭제
                imgDiv.appendChild(imgElement);
            };

            // 파일을 읽기
            reader.readAsDataURL(file);

            // formVo에 저장
            setFormVo({
                ...formVo,
                [imgInp.name]: imgInp.value,
            });
        }

    }

    // formVo에 값 저장
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormVo({
            ...formVo,
            [name]: value
        });
    };
    console.log(formVo);

    return (
        <StyledCreateBasicDiv>
            <div className="contentDiv">
                <dl>
                    <dt>프로젝트 카테고리</dt>
                    <dd>
                        <dl className='item'>
                            <dt>대분류 카테고리</dt>
                            <dd>
                                <select name="mainCategoryNo" onChange={handleInputChange}>
                                    <option value="1">카테고리 대분류</option>
                                    <option value="2">카테고리 대분류</option>
                                </select>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>소분류 카테고리</dt>
                            <dd>
                                <select name="subCategoryNo" onChange={handleInputChange}>
                                    <option value="1">카테고리 소분류</option>
                                </select>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl>
                    <dt>프로젝트 제목</dt>
                    <dd>
                        <dl className='item'>
                            <dt>프로젝트 제목</dt>
                            <dd>
                                <input type="text" name='title' onChange={handleInputChange} />
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl>
                    <dt>프로젝트 대표이미지</dt>
                    <dd>
                        <dl className='item img'>
                            <dt>이미지 업로드</dt>
                            <dd>
                                <span className="img"></span>
                                <input type="file" id='imgFileUpload' name='imageUrl' accept='image/*' onChange={handleImgCreate}/>
                                <label htmlFor="imgFileUpload">이미지 업로드</label>
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreateBasicDiv>
    );
};

export default ProjectBasicCreate;