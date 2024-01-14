import React from 'react';
import styled from 'styled-components';
import { useBackingMemory } from '../../../component/context/BackingContext';
import {useNavigate, useNavigation} from 'react-router-dom';

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

        & > span {
            font-weight: 600;
            color: var(--red-color);
        }
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
        letter-spacing: 0.4px;
    }
`;

const PaymentCheck = () => {

    // useNavigate
    const navigate = useNavigate();

    // useContext
    const dataSet = useBackingMemory();
    const back = dataSet.dataVo;
    console.log(back);
    
    // 체크박스 체크여부 확인 함수
    const checkCheckInput = () => {
        const checkbox = document.querySelector('input[name=check_yn]');
        let is_checked = false;
        if(checkbox.checked) {
            is_checked = true;
        }

        return is_checked;
    }

    const checkCardInput = () => {
        let check1 = false;
        if(back.cardNo1 && back.cardNo2 && back.cardNo3 && back.cardNo4) {
            check1 = true;
        } 
        console.log("cardNo null check :: ", check1);

        let check2 = false;
        if(back.cardNo1.length === 4 && back.cardNo2.length === 4 && back.cardNo3.length === 4 && back.cardNo4.length === 4) {
            check2 = true;
        }
        console.log("cardNo length check :: ", check2); 

        let check3 = false;
        if(back.validThru1 && back.validThru2) {
            check3 = true;
        }
        console.log("validThru null check :: ", check3);

        let check4 = false;
        if(back.validThru1.length === 2 && back.validThru2.length === 2) {
            check4 = true;
        }
        console.log("validTru length check :: ", check4);

        let check5 = false;
        if(back.cardPwd && back.birthDate) {
            check5 = true;
        }
        console.log("ownerInfo null check :: ", check5);

        let check6 = false;
        if(back.cardPwd.length === 2 && back.birthDate.length === 6) {
            check6 = true;
        }
        console.log("ownerInfo length check", check6);
        // if((back.cardNo1 && back.cardNo2 && back.cardNo3 && back.cardNo4)
        // && (back.cardNo1.length === 4 && back.cardNo2.length === 4 && back.cardNo3.length === 4 && back.cardNo4.length === 4)
        // && (back.validThru1 && back.validThru2)
        // && (back.validThru1.length === 2 && back.validThru2.length === 2)
        // && (back.cardPwd && back.birthDate)
        // && (back.cardPwd.length === 2 && back.birthDate.length === 6)) {
        //     return true;
        // } else {
        //     return false;
        // }
        if(check1 === true && check2 === true && check3 === true && check4 === true &&
            check5 === true && check6 === true) {
                return true;
        } else {
            return false;
        }

    }


    const handleBackBtnClick = (e) => {

        e.preventDefault();

        // 유효성 체크
        // PaymentType undefined체크
        let paymentTypeDefined = false;
        if(back.paymentType) {
            paymentTypeDefined = true;
        }

        // PaymentType이 카드 결제일 시 카드정보 null체크
        const cardInfoOk = checkCardInput();

        // 체크박스 체크 여부
        const checkboxOk = checkCheckInput();

        console.log(paymentTypeDefined);
        console.log(cardInfoOk);
        console.log(checkboxOk);
        if(paymentTypeDefined && cardInfoOk && checkboxOk) {
            fetch("http://127.0.0.1:8889/gamepound/back/process", {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(back)
            })
            .then(resp => resp.json())
            .then(data => {
                if(data.result==="success") {
                    navigate("/back/completed");
                }
            })
            ;
        } else {
            alert("후원 정보가 빠진 곳 없이 입력되었는지 확인해주세요.");
        }
        
        
    }

    return (
        <StyledPaymentCheckDiv>
            <div className="final_amount">
                <span>최종 후원 금액</span>
                <span>{back.rewardAmount} 원</span>
            </div>

            <div className="payment_due">프로젝트 성공 시, 결제는 <span>{back.paymentDueDate}</span> 에 진행됩니다.<br/> 
                프로젝트가 무산 또는 중단된 경우, 예약된 결제는 자동으로 취소됩니다.
            </div>
            
            <div className="checkbox_area">
                <label><input type="checkbox" name='check_yn' />개인정보 제3자 제공 동의</label>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            </div>
            
            <button onClick={handleBackBtnClick}>후원하기</button>
        </StyledPaymentCheckDiv>
    );
};

export default PaymentCheck;