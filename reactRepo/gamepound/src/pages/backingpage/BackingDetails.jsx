import React, { useState } from 'react';
import styled from 'styled-components';
import EnrollCard from '../../component/payment/EnrollCard';

const StyledBackingDetailsDiv = styled.div`
    width: 800px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;

    & > .detail_box {
        width: 780px;
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

const BackingDetails = () => {

    const [showCard, setShowCard] = useState(false);
    const handleCardClick = () => {
        setShowCard(true);
    }

    const handleKakaoPayClick = () => {
    }

    return (
        <StyledBackingDetailsDiv>
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
            <div className='detail_box' id='backer_info'>
                <div className='title'>후원자 정보</div>
                <div className='detail'>
                    <div className='detail_1'>
                        <span>이메일</span>
                        <span>glee1470@naver.com</span>
                    </div>
                    <div className='detail_2'>
                        <p>* 위 이메일로 후원 관련 소식이 전달됩니다.<br />
                           * 이메일은 가입 시 등록한 이메일로 자동 설정됩니다.</p>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='paymentType_info'>
                <div className='title'>결제 수단</div>
                <div className='paymentType'>
                    <label><input type='radio' name='paymentType' value='card' onClick={handleCardClick} />카드 결제</label>
                    <label><input type='radio' name='paymentType' value='kakaopay' onClick={handleKakaoPayClick} />카카오페이</label>
                </div>
                {
                    showCard===true
                    ?
                    <EnrollCard />
                    :
                    <div></div>
                }
            </div>
        </StyledBackingDetailsDiv>
    );
};

export default BackingDetails;