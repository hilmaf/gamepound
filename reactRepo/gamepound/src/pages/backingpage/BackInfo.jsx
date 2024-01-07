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

const BackInfo = () => {
    return (
        <StyledBackInfoDiv>
            <div className='detail_box' id='reward_info'>
                <div className='title'>선물 정보</div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>선물 구성</span>
                        <span>어쩌고저쩌고</span>
                    </div>
                    <div className='detail_2'>
                        <span>선물 금액</span>
                        <span>21,000원</span>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='reward_info'>
                <div className='title'>선물 정보</div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>선물 구성</span>
                        <span>어쩌고저쩌고</span>
                    </div>
                    <div className='detail_2'>
                        <span>선물 금액</span>
                        <span>21,000원</span>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='reward_info'>
                <div className='title'>선물 정보</div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>선물 구성</span>
                        <span>어쩌고저쩌고</span>
                    </div>
                    <div className='detail_2'>
                        <span>선물 금액</span>
                        <span>21,000원</span>
                    </div>
                </div>
            </div>
        </StyledBackInfoDiv>
    );
};

export default BackInfo;