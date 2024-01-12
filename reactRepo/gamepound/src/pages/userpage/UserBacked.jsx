import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import BackBriefInfo from '../../component/back/BackBriefInfo';
import { useUserMemory } from '../../component/context/UserContext';

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

    const {loginMemberVo} = useUserMemory();

    const [backedVo, setBackedVo] = useState({});
    let {cnt, successList, failList, successCnt, failCnt} = backedVo

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage/backed?user=" + loginMemberVo.no)
        .then(resp => resp.json())
        .then(data => {
            setBackedVo(data);
        })
        ;
    }, [])
    return (
        <StyledUserBackedDiv>
                <div id="cnt">{cnt}건의 후원 내역이 있습니다.</div>
                <div className='back_items'>
                    <div id='success_cnt'>후원 성공({successCnt}개)</div>
                    {
                        successCnt>=0
                        ?
                        successList.map((item)=>{
                            return <BackBriefInfo item={item}/>
                        })
                        :
                        <div id='noItems'>
                        </div>
                    }
                </div>
                <div className='back_items'>
                    <div id='fail_cnt'>후원 실패({failCnt}개)</div>
                    {
                        failCnt>=0
                        ?
                        failList.map((item)=>{
                            return <BackBriefInfo list={item}/>
                        })
                        :
                        <div id='noItems'>
                        </div>
                    }
                </div>
        </StyledUserBackedDiv>
    );
};

export default UserBacked;