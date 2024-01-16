import React from 'react';
import styled from 'styled-components';

const StyledCreateUserinfoDiv = styled.div`
    & .inner {
        width: 1200px;
        margin: 0 auto;
        padding: 40px 0;
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
            flex-wrap: wrap;
            justify-content: flex-end;
            gap: 40px 60px;
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
                    & > dd {

                    }
                }
            }
        }
    }
`;

const ProjectUserinfoCreate = () => {
    return (
        <StyledCreateUserinfoDiv>
            <div className="inner">
                <dl>
                    <dt>임금 계좌</dt>
                    <dd>
                        <dl className='item'>
                            <dt>거래 은행</dt>
                            <dd>
                                <select name="">
                                    <option value="">선택</option>
                                    <option value="">기업은행</option>
                                    <option value="">국민은행</option>
                                    <option value="">신한은행</option>
                                    <option value="">농협은행</option>
                                    <option value="">카카오뱅크</option>
                                </select>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>예금주명</dt>
                            <dd>
                                <input type="text" />
                            </dd>
                        </dl>
                    </dd>
                    <dd>
                        <dl className='item'>
                            <dt>계좌번호</dt>
                            <dd>
                                <input type="text" placeholder="'-' 하이픈 없이 작성" />
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreateUserinfoDiv>
    );
};

export default ProjectUserinfoCreate;