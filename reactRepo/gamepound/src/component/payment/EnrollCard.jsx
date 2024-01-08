import React from 'react';
import styled from 'styled-components';

const StyledEnrollCardDiv = styled.div`
    width: 500px;
    height: 400px;
    border: 1px solid #3d3d3d;
`;

const EnrollCard = () => {
    return (
        <StyledEnrollCardDiv>
            <div class='card_number'>
                <div>카드번호</div>
                <input type='text'/> - <input type='text'/> - <input type='text'/> - <input type='text'/>
            </div>
            <div class='avail_period'>
                <div>카드 유효기간</div>
                <input type='text'/>
                <input type='text'/>
            </div>
            <div class='owner_info'>
                <div class='pwd'>

                </div>
                <div class='birth_date'>

                </div>
            </div>
        </StyledEnrollCardDiv>
    );
};

export default EnrollCard;