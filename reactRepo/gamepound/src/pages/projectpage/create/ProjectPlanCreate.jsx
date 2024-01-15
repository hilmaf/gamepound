import React, { useState } from 'react';
import styled from 'styled-components';
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";

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
                        & > div {
                            width: 100%;
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

    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);

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
                                <DatePicker 
                                    dateFormat='yyyy-MM-dd' // 날짜 형태
                                    shouldCloseOnSelect // 날짜를 선택하면 datepicker가 자동으로 닫힘
                                    selected={startDate}
                                    onChange={(date) => setStartDate(date)}
                                    minDate={new Date()} // 시작일은 오늘 이후로 선택
                                    selectsStart
                                    startDate={startDate}
                                    endDate={endDate}
                                />
                            </dd>
                        </dl>
                        <dl className='item'>
                            <dt>종료일</dt>
                            <dd>
                                <DatePicker
                                    dateFormat='yyyy-MM-dd' // 날짜 형태
                                    shouldCloseOnSelect // 날짜를 선택하면 datepicker가 자동으로 닫힘
                                    selected={endDate}
                                    onChange={(date) => setEndDate(date)}
                                    selectsEnd
                                    startDate={startDate}
                                    endDate={endDate}
                                    minDate={startDate} // 종료일은 시작일 이후여야 함
                                />
                            </dd>
                        </dl>
                    </dd>
                </dl>
            </div>
        </StyledCreatePlanDiv>
    );
};

export default ProjectPlanCreate;