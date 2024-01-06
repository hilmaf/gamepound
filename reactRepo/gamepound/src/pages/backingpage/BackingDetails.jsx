import React from 'react';
import styled from 'styled-components';

const StyledBackingDetailsDiv = styled.div`
    width: 800px;
`;

const BackingDetails = () => {

    const handleCardClick = () => {
        return (
            <div className="card">

            </div>
        )
    }

    const handleKakaoPayClick = () => {
        return (
            <div className="kakaopay">

            </div>
        )
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
                        <p>* 위 이메일로 후원 관련 소식이 전달됩니다.
                           * 이메일은 가입 시 등록한 이메일로 자동 설정됩니다.</p>
                    </div>
                </div>
            </div>
            <div className='detail_box' id='paymentType_info'>
                <div className='title'>결제 수단</div>
                <div className='paymentType'>
                    <input type='radio' name='paymentType' value='card' onClick={handleCardClick}>카드 결제</input>
                    <input type='radio' name='paymentType' value='kakaopay' onClick={handleKakaoPayClick}>카카오페이</input>
                </div>
            </div>
        </StyledBackingDetailsDiv>
    );
};

export default BackingDetails;