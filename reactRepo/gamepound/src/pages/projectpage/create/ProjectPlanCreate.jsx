import React from 'react';
import styled from 'styled-components';

const StyledCreatePlanDiv = styled.div`
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
                    & dd {
                        position: relative;
                        & .won {
                            position: absolute;
                            top: 50%;
                            right: 15px;
                            margin-top: -11px;
                            font-size: 14px;
                            color: #333;
                        }
                        & input[name=goalAmount] {
                            text-align: right;
                            padding-right: 42px;
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

const ProjectPlanCreate = () => {
    return (
        <StyledCreatePlanDiv>
            <div className="contentDiv">
                <dl>
                    <dt>목표 금액</dt>
                    <dd>
                        <dl className='item'>
                            <dt>목표 금액</dt>
                            <dd>
                                <input type="text" name='goalAmount' placeholder='50만원 이상의 금액을 입력해주세요' /><span className='won'>원</span>
                            </dd>
                        </dl>
                    </dd>
                </dl>
                <dl>
                    <dt>펀딩 일정</dt>
                    <dd>
                        <dl className='item'>
                            <dt>시작일</dt>
                            <dd>
                                <input type="text" name='startDate' />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>종료일</dt>
                            <dd>
                                <input type="text" name='endDate' />
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreatePlanDiv>
    );
};

export default ProjectPlanCreate;