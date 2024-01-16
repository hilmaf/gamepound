import React from 'react';
import styled from 'styled-components';

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
`;

const ProjectDateplanCreate = () => {
    return (
        <StyledCreateDateplanDiv>
            <div className="inner">
                <dl>
                    <dt>프로젝트 계획</dt>
                    <dd>
                        <dl className='item'>
                            <dt>프로젝트 소개</dt>
                            <dd>
                                <textarea name=""></textarea>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 예산</dt>
                            <dd>
                                <textarea name=""></textarea>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 일정</dt>
                            <dd>
                                <textarea name=""></textarea>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 팀 소개</dt>
                            <dd>
                                <textarea name=""></textarea>
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>프로젝트 선물 소개</dt>
                            <dd>
                                <textarea name=""></textarea>
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreateDateplanDiv>
    );
};

export default ProjectDateplanCreate;