import React from 'react';
import styled from 'styled-components';
import BackBriefInfo from '../../component/back/BackBriefInfo';

const StyledUserBackedDiv = styled.div`
    padding-left: 20px;

    & > #cnt {
        height: 80px;
        line-height: 80px;
    }

    & > .back_items {

        & > #success_cnt, #fail_cnt {
            height: 50px;
            line-height: 50px;
            padding-bottom: 10px;
        }
    }
`;

const UserBacked = () => {
    return (
        <StyledUserBackedDiv>
                <div id="cnt">--n--건의 후원 내역이 있습니다.</div>
                <div className='back_items'>
                    <div id='success_cnt'>후원 성공(n개)</div>
                    <BackBriefInfo />
                </div>
                <div className='back_items'>
                    <div id='fail_cnt'>후원 실패(n개)</div>
                    <BackBriefInfo />
                </div>
        </StyledUserBackedDiv>
    );
};

export default UserBacked;