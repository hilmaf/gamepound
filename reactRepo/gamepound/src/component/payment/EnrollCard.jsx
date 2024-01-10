import React from 'react';
import styled from 'styled-components';

const StyledEnrollCardDiv = styled.div`
    width: 700px;
    height: 250px;
    border: 1px solid #3d3d3d22;
    border-radius: 5px;
    padding: 30px;
    padding-left: 50px;
    font-size: 14px; 
    
    & > .card_number {
        width: 500px;
        
        & > div {
            margin-bottom: 10px;
        }
        
        & > input {
            width: 50px;
            height: 30px;
            border: 1px solid #3d3d3d66;
            border-radius: 5px;
        }
    }

    & > .avail_period {
        padding-top: 30px;
        width: 500px;
        
        & > :nth-child(2) {
            width: 30px;
            height: 30px;
            margin-top: 10px;
            margin-right: 10px;
            border: 1px solid #3d3d3d66;
            border-radius: 5px;
        }

        & > :nth-child(3) {
            width: 30px;
            height: 30px;
            margin-top: 10px;
            margin-left: 10px;
            border: 1px solid #3d3d3d66;
            border-radius: 5px;
        }
    }

    & > .owner_info {
        padding-top: 30px;
        width: 500px;
        display: flex;

        & > :nth-child(1), :nth-child(2) {
            width: 200px;
            margin-right: 60px;
            border-radius: 5px;
            
            & > input {
                height: 30px;
                margin-top: 10px;
                border: 1px solid #3d3d3d66;
                border-radius: 5px;
            }
        }
    }
`;

const EnrollCard = () => {
    return (
        <StyledEnrollCardDiv>
            <div className='card_number'>
                <div>카드번호</div>
                <input type='text'/> - <input type='text'/> - <input type='text'/> - <input type='text'/>
            </div>
            <div className='avail_period'>
                <div>카드 유효기간</div>
                <input type='text'/>
                /
                <input type='text'/>
            </div>
            <div className='owner_info'>
                <div className='pwd'>
                    <div>카드 비밀번호 앞 2자리</div>
                    <input type='text'/>
                </div>
                <div className='birth_date'>
                    <div>생년월일 6자리</div>
                    <input type='text'/>
                </div>
            </div>
        </StyledEnrollCardDiv>
    );
};

export default EnrollCard;