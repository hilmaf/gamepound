import React from 'react';
import styled from 'styled-components';

const StyledPaymentCheckDiv = styled.div`
    width: 380px;
    height: 350px;
    margin-top: 20px;
    padding-bottom: 20px;
    
    & > .final_amount {
        height: 60px;
        border: 1px solid var(--red-color);
        border-radius: 5px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        
        & > span {
            color: var(--red-color);
            padding-left: 20px;
            padding-right: 20px;
            font-weight: 400;
        }
    }

    & > .payment_due {
        font-size: 13px;
        padding: 10px;
    }

    & > .checkbox_area {
        padding: 10px;

        & > label {

            & > input {
                margin-right: 10px;
            }

        }
    }

    & > button {
        height: 60px;
        width: 100%;
        border-radius: 5px;
        margin-top: 20px;
        background-color: var(--red-color);
        font-size: 16px;
        color: white;
        font-weight: 400;
        letter-spacing: 0.9px;
    }
`;

const PaymentCheck = () => {

    const handleBackBtnClick = () => {
        
    }

    return (
        <StyledPaymentCheckDiv>
            <div className="final_amount">
                <span>최종 후원 금액</span>
                <span>29,000원</span>
            </div>

            <div className="payment_due">프로젝트 성공 시, 결제는 2024.01.06 에 진행됩니다.<br/> 
                프로젝트가 무산 또는 중단된 경우, 예약된 결제는 자동으로 취소됩니다.
            </div>
            
            <div className="checkbox_area">
                <label><input type="checkbox" />개인정보 제3자 제공 동의</label>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            </div>
            
            <button onClick={handleBackBtnClick}>후원하기</button>
        </StyledPaymentCheckDiv>
    );
};

export default PaymentCheck;