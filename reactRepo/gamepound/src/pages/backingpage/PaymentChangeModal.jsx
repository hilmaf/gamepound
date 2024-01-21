import React, { useState } from 'react';
import styled from 'styled-components';
import EnrollCard from '../../component/payment/EnrollCard';

const StyledPaymentChangeDiv = styled.div`
    width: 250px;
    height: 400px;
`;


const PaymentChangeModal = () => {
    
    const [cardData, setCardData] = useState({});

    const handleCardInputsChange = (e) => {
        const {name, value} = e.target;

        setCardData({
            ...cardData,
            [name]: value
        });
    }


    return (
        <StyledPaymentChangeDiv>
            <div className='cardNo'>
                <div>카드 번호</div>
                <input type='text' className='cardInput' name='cardInput1' onKeyUp={handleCardInputsChange}/> 
                <input type='text' className='cardInput' name='cardInput2' onKeyUp={handleCardInputsChange}/>
                <input type='text' className='cardInput' name='cardInput3' onKeyUp={handleCardInputsChange}/>
                <input type='text' className='cardInput' name='cardInput4' onKeyUp={handleCardInputsChange}/> 
            </div>
            <div className='validThru'>
                <div>유효 기간</div>
                <input type='text' className='validThru' name='validThru1' onKeyUp={handleCardInputsChange}/> 
                <input type='text' className='validThru' name='validThru2' onKeyUp={handleCardInputsChange}/> 
            </div>
            <div className='cardPwd'>
                <div>카드 비밀번호</div>
                <input type='text' className='cardPwd' name='cardPwd' onKeyUp={handleCardInputsChange}/> 
            </div>
            <div className='birthDate'>
                <div>생년월일 6자리</div>
                <input type='text' className='birthDate' name='birthDate' onKeyUp={handleCardInputsChange}/> 
            </div>
            <button>변경</button>
        </StyledPaymentChangeDiv>
    );
};

export default PaymentChangeModal;