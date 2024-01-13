import React from 'react';
import styled from 'styled-components';

const StyledBackInfoDiv = styled.div`
    & > .detail_box {
        width: 1200px;
        padding-top: 20px;
        padding-bottom: 20px;

        & > .title {
            font-size: 16px;
            color: #3d3d3d;
            padding: 5px;
            padding-bottom: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;

            & > button {
                width: 60px; 
                height: 35px;
                background-color: white;
                color: var(--red-color);
                border: 1px solid var(--red-color);
                border-radius: 10px;
                cursor: pointer;
            }
        }

        & > .detail {
            border: 1px solid #3d3d3d;
            padding: 5px;

            & > .detail_1 {
                font-size: 14px; 
                color: #3d3d3d;
                padding-left: 12px;
                padding-top: 15px;
                padding-bottom: 15px;

                & > .span {
                }
            }
            
            & > .detail_2 {
                font-size: 14px;                
                color: #3d3d3d;               
                padding-left: 12px;
                padding-top: 15px;
                padding-bottom: 15px;
            }
        }

        & > .paymentType {
            border: 1px solid #3d3d3d;
        }
    }
    
`;

const BackInfo = ({BackInfo}) => {
    return (
        <StyledBackInfoDiv>
            <div className='detail_box' id='reward_info'>
                <div className='title'>
                    후원 정보
                </div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>펀딩 상태</span>
                        <span>{BackInfo.rewardName}</span>
                    </div>
                    <div className='detail_2'>
                        <span>후원 날짜</span>
                        <span>{BackInfo.backingDate}</span>
                    </div>
                    <div className='detail_2'>
                        <span>펀딩 마감일</span>
                        <span>{BackInfo.endDate}</span>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='reward_info'>
                <div className='title'>
                    <span>선물 정보</span>
                    <button>변경</button>
                </div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>선물 구성</span>
                        <span>{BackInfo.rewardName}</span>
                    </div>
                    <div className='detail_2'>
                        <span>선물 금액</span>
                        <span>{BackInfo.rewardAmount}</span>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='reward_info'>
                <div className='title'>
                    <span>결제 정보</span>
                    <button>변경</button>
                </div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>결제 수단</span>
                        <span>{BackInfo.paymentType}</span>
                    </div>
                    <div className='detail_2'>
                        <span>결제 금액</span>
                        <span>{BackInfo.paymentAmount}원</span>
                    </div>
                </div>
            </div>
        </StyledBackInfoDiv>
    );
};

export default BackInfo;